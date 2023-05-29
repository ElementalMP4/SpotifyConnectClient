systemctl stop RaspiSonos-API
systemctl stop LibrespotJava

systemctl disable RaspiSonos-API
systemctl disable LibrespotJava

rm -rf /home/pi/RaspiSonos

rm /usr/lib/systemd/system/RaspiSonos-API.service
rm /usr/lib/systemd/system/LibrespotJava.service