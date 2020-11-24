#!/bin/bash

set -euxo pipefail

docker build . -t originalapp
docker run -d -p 8080:8080 -v "$HOME/.m2":/root/.m2 --rm originalapp

#frontend
./frontend/build.sh
