#!/bin/bash

# Thanks to t184256
# Requires Inkscape and Imagemagic

PNGDIR="../app/src/main/res"
NEWDIR="new"
MVDIR="done"

for SVG in ${NEWDIR}/*.svg
do
    N=$(basename $SVG .svg)
    inkscape -f $SVG -w 48 -h 48 -e \
        ${PNGDIR}/drawable-mdpi/$N.png
    inkscape -f $SVG -w 72 -h 72 -e \
        ${PNGDIR}/drawable-hdpi/$N.png
    inkscape -f $SVG -w 96 -h 96 -e \
        ${PNGDIR}/drawable-xhdpi/$N.png
    inkscape -f $SVG -w 144 -h 144 -e \
        ${PNGDIR}/drawable-xxhdpi/$N.png
    inkscape -f $SVG -w 192 -h 192 -e \
        ${PNGDIR}/drawable-xxxhdpi/$N.png
    inkscape -f $SVG -w 384 -h 384 -e \
        ${PNGDIR}/drawable-nodpi/nodpi_$N.png
    mv ${SVG} ${MVDIR}
done
