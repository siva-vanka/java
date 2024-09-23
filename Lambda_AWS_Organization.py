import boto3
import json
import time

def lambda_handler(event, context):
    # Initialize AWS clients
    organizations_client = boto3.client('organizations')
    lambda_client = boto3.client('lambda')

    # Retrieve all accounts in the organization
    response = organizations_client.list_accounts()
    accounts = response['Accounts']
    while 'NextToken' in response:
        response = organizations_client.list_accounts(NextToken=response['NextToken'])
        accounts.extend(response['Accounts'])

    # Create a list to store account IDs and alt tags
    account_data = []

    for account in accounts:
        account_id = account['Id']
        account_name = account['Name']
        account_email = account['Email']

        # Use describe_account to get additional details
        describe_account_response = organizations_client.describe_account(AccountId=account_id)
        account_status = describe_account_response['Account']['Status']

        # Check if the account is active and has an alt tag
        if account_status == 'ACTIVE' and 'tags' in describe_account_response['Account']:
            alt_tag_value = None
            for tag in describe_account_response['Account']['tags']:
                if tag['Key'] == 'AltTag':
                    alt_tag_value = tag['Value']
                    break

            # Add account information to the list
            account_data.append({
                'AccountId': account_id,
                'AccountName': account_name,
                'AccountEmail': account_email,
                'AltTag': alt_tag_value
            })

    # Convert account data to JSON format
    json_data = json.dumps(account_data, indent=4)

    # Log the JSON data
    print(json_data)

    # Optionally, you can send the JSON data to another service or store it in a database

    # Schedule the Lambda function to run daily (adjust the rate expression as needed)
    lambda_client.update_function_configuration(
        FunctionName=context.function_name,
        Timeouts={
            'Timeout': 300  # Adjust timeout as needed
        },
        Environment={
            'Variables': {
                # Add any necessary environment variables here
            }
        },
        ScheduleExpression="rate(1 day)"
    )

    return {'statusCode': 200, 'body': json_data}