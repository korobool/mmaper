#coding: utf-8
import sys
from Tkinter import *
from xml.dom.minidom import parse
from model import get_shapes

dom1 = parse(sys.argv[1])

root = Tk()
canvas = Canvas(root, width=300, height=300)
canvas.pack()

xml_shapes = get_shapes(dom1)

s_width = 30
s_height = 30

ellipse = lambda x, y: canvas.create_oval(x, y,
                                          x + s_width, y + s_height,
                                          fill="blue")
rectangle = lambda x, y: canvas.create_rectangle(x, y, x + s_width,
                                                 y + s_height,
                                                 fill="red")
rhomb = lambda x, y: canvas.create_polygon(x + s_width/2, y,
                                           x + s_width, y + s_height/2,
                                           x + s_width/2, y + s_height,
                                           x, y + s_height/2,
                                           fill="green")
connection = lambda x1, y1, x2, y2: canvas.create_line(x1+s_width/2, y1+s_height/2,
                                                       x2+s_width/2, y2+s_height/2,
                                                       width=1.0)
shapes = {"ellipse": ellipse,
          "rectangle": rectangle,
          "rhomb": rhomb,
          "connection": connection}

for shape in xml_shapes:
    if shape["shape"] == "connection":
        shapes.get(shape["shape"])(int(shape["x1"]), int(shape["y1"]),
                                   int(shape["x2"]), int(shape["y2"]))
        continue
    shapes.get(shape["shape"])(int(shape["x"]), int(shape["y"]))

root.mainloop()
