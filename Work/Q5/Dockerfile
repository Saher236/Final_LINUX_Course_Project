#Dockerfile 1
FROM python:3.9-slim
#RUN apt-get update && apt-get install -y nano imagemagick && rm -rf /var/lib/apt/lists/*
WORKDIR /app
#COPY Work/Q2/plant.py .
#RUN pip install matplotlib numpy
#CMD ["/bin/bash"]

#Dockerfile 2
COPY Work/Q2/plant_plots.py .
COPY Work/Q2/requirements.txt .
RUN pip install --no-cache-dir -r requirements.txt
ENTRYPOINT ["python3", "plant_plots.py"]
CMD ["--help"]
