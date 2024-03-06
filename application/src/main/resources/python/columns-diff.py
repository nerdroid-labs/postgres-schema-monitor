import pprint
import requests
from deepdiff import DeepDiff


def get_columns(host):
    response = requests.get(f"{host}/api/database/public/columns")

    if not response.ok:
        raise RuntimeError("retrieving columns failed")

    return response.json()


SERVER_DEV = "https://"
SERVER_PROD = "https://"
diff = DeepDiff(get_columns(SERVER_DEV), get_columns(SERVER_PROD), ignore_order=True)
if not diff:
    print("columns are equal.")
else:
    pprint.pprint(diff)
