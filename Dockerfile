# Build on top of the Java TAG image
FROM ghcr.io/moio/tag:latest

# Get the PyTAG project sources
ADD . /PyTAG
WORKDIR /PyTAG

# Install Python and dependencies
RUN zypper in -y python311 python311-pip

RUN pip3.11 install -r ./pytag/requirements.txt
RUN pip3.11 install -e .
RUN pip3.11 install -e .[examples]


RUN mv /jars/* /PyTAG/pytag/jars

ENTRYPOINT ["python3.11", "/PyTAG/examples/ppo-lstm.py"]
