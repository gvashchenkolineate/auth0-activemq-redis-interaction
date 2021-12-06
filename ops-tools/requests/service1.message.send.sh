#!/bin/bash

timestamp=$(date "+%Y%m%d-%H%M%S")

curl -X POST \
  -H "Content-Type: application/json" \
  -d '{"message": "Timestamp: '"$timestamp"'"}' \
  http://localhost:3010/api/token/send
