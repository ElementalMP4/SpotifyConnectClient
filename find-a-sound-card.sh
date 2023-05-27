#!/bin/bash

SOUND_CARD_STRING=`cat /proc/asound/cards | grep USB`
SOUND_CARD_NUMBER="$(echo $SOUND_CARD_STRING | head -c 1)"

echo $SOUND_CARD_STRING
echo $SOUND_CARD_NUMBER

sudo rm -f /etc/asound.conf

sudo echo "defaults.pcm.card $SOUND_CARD_NUMBER" >> /etc/asound.conf
sudo echo "defaults.ctl.card $SOUND_CARD_NUMBER" >> /etc/asound.conf

sudo systemctl restart LibrespotJava