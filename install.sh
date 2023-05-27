sudo apt-get install git maven openjdk-17-jdk -y

git clone https://github.com/ElementalMP4/RaspiSonos /var/tmp/RaspiSonos
git clone https://github.com/ElementalMP4/librespot-java /var/tmp/librespot-java

cd /var/tmp/librespot-java/api
mvn clean package

mkdir -p /home/pi/RaspiSonos
cp target/librespot-api-1.6.3.jar /home/pi/RaspiSonos

