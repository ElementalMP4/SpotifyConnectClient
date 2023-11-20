echo Install dependencies

apt-get install git maven openjdk-17-jdk -y
mkdir -p /opt/spotify

echo Pull things from git

git clone https://github.com/ElementalMP4/SpotifyConnectClient /var/tmp/spotify
git clone https://github.com/ElementalMP4/librespot-java /var/tmp/librespot-java

echo Build librespot-java

cd /var/tmp/librespot-java/api
mvn clean package
cp target/librespot-api-*.jar /opt/spotify/librespot.jar

echo Set up the systemctl unit

cp /var/tmp/spotify/setup/librespot.sh /opt/spotify/
cp /var/tmp/spotify/setup/librespot.service /usr/lib/systemd/system/
systemctl daemon-reload
systemctl enable librespot
systemctl start librespot

echo Cleanup

sudo rm -rf /var/tmp/spotify /var/tmp/librespot-java