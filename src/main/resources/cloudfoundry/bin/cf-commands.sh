# !/bin/bash
# Bash shell script to execute cf CLI commands.

cf cups apacheGeodeService -t "gemfire, cloudcache, database, pivotal" -p '{ "locators": [ "10.99.199.24[10334]" ], "urls": { "gfsh": "https://10.99.199.24:8080/gemfire/v1" }, "users": [{ "password": "admin", "roles": [ "cluster_operator" ], "username": "admin" }] }'