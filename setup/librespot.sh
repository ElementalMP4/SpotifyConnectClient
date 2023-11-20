cd /opt/spotify

JAVA_OPTIONS=" -XX:+UseSerialGC -Xss256k -XX:MaxRAM=72m -Xms128m -Xmx512m"

java $JAVA_OPTIONS -jar librespot.jar