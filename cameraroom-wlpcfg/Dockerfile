FROM websphere-liberty:latest

MAINTAINER Ross Pavitt

ADD ./servers/gameon-cameraroom /opt/ibm/wlp/usr/servers/defaultServer/

COPY ./startup.sh /opt/startup.sh

EXPOSE 9080

CMD ["/opt/startup.sh"]
