import pprint
import requests
from deepdiff import DeepDiff


def get_indexes(host):
    response = requests.get(f"{host}/api/database/public/indexes")

    if not response.ok:
        raise RuntimeError("retrieving indexes failed")

    return response.json()


SERVER_DEV = "https://"
SERVER_PROD = "https://"
diff = DeepDiff(get_indexes(SERVER_DEV), get_indexes(SERVER_PROD), ignore_order=True)
if not diff:
    print("indexes are equal.")
else:
    pprint.pprint(diff)
