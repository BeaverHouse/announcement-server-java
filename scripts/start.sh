nohup java -jar app.jar &
echo $(pgrep -f java) > pid.txt
echo "App started"
