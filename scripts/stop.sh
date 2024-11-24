PID=$(cat pid.txt)
if [ -z "$PID" ]; then
    echo "App is not running"
else
    kill $PID
    echo "App stopped"
fi
rm pid.txt
