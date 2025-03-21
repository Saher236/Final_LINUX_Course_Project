#!/bin/bash
PYTHON_IMAGE="plant-plots-container"
JAVA_IMAGE="java-watermark"
OUTPUT_DIR="output"
STUDENT1INFO="Rami AbuJabal - ID: 206528085"
STUDENT2INFO="Saher Jammal - ID: 209404946"
WATERMARKED_DIR="output_watermarked"

rm -rf $OUTPUT_DIR $WATERMARKED_DIR
mkdir -p $OUTPUT_DIR $WATERMARKED_DIR

docker run --rm -v $(pwd)/$OUTPUT_DIR:/app/output $PYTHON_IMAGE --plant "Tulip" --height 50 55 60 65 70 --leaf_count 35 40 45 50 55 --dry_weight 2.0 2.2 2.5 2.7 3.0

docker run --rm -v $(pwd)/$OUTPUT_DIR:/app/input -v $(pwd)/$WATERMARKED_DIR:/app/output $JAVA_IMAGE /app/input /app/output "$STUDENT1INFO" "$STUDENT2INFO"

ls -l $WATERMARKED_DIR
docker system prune -a -f
