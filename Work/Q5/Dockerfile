FROM python:3.9-slim

RUN apt-get update && apt-get install -y nano imagemagick && rm -rf /var/lib/apt/lists/*

WORKDIR /app

COPY Work/Q2/plant.py .

RUN pip install matplotlib numpy

CMD ["/bin/bash"]
