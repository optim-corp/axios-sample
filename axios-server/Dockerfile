FROM maven:3-jdk-8-alpine
ADD . /code/
COPY ../openapi/petstore.yaml /code/
RUN echo "Build jar" && \
    echo '{ "allow_root": true }' > /root/.bowerrc && \
    cd /code/axios-server && \
    ls  /code/axios-server/../openapi && \
