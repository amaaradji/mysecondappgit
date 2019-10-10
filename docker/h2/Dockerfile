# Creates the minimum environment to package and run this Skyve application.
# Note that this uses an in-memory database and is only useful for demonstration/development.
FROM bizhubaustralia/skyve-wildfly

ENV LANG en_US.UTF-8

USER root
RUN mkdir /content
RUN chown jboss:jboss /content

USER jboss
ADD myfirstapp.war /opt/jboss/wildfly/standalone/deployments/myfirstapp.war
ADD myfirstapp.json /opt/jboss/wildfly/standalone/deployments
ADD myfirstapp-ds.xml /opt/jboss/wildfly/standalone/deployments
RUN touch /opt/jboss/wildfly/standalone/deployments/myfirstapp.war.dodeploy

ENV SKYVE_CONTENT='/content/' \
    SKYVE_DATASTORE_DIALECT='org.skyve.impl.persistence.hibernate.dialect.H2SpatialDialect' \
    DATABASE_URL='myfirstapp_db' \
    SKYVE_SECURITY_DOMAIN_NAME='myfirstapp' \
    SKYVE_JNDI_NAME='myfirstappDB'

ENTRYPOINT [ "entrypoint.sh" ]