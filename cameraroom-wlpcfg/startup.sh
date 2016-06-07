#!/bin/bash

if [ "$IMAGE_SVC_URL" == "" ]; then
  export IMAGE_SVC_URL=http://192.168.0.103:8000/user
fi

if [ "$REQUIRES_APP_REGISTRATION" == "" ]; then
  export REQUIRES_APP_REGISTRATION=false
fi

/opt/ibm/wlp/bin/server run defaultServer
