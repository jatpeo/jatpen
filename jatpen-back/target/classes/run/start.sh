#!/usr/bin/env bash
nohup java -jar *****.jar > api.log 2>&1&
echo $! > pid.txt