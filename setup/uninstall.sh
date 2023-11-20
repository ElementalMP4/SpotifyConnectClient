systemctl stop librespot
systemctl disable librespot

rm -rf /opt/spotify

rm /usr/lib/systemd/system/librespot.service

systemctl daemon-reload