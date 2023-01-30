FROM airhacks/glassfish
COPY ./target/JavaEEConcurrency.war ${DEPLOYMENT_DIR}
