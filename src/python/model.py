from xml.dom.minidom import getDOMImplementation

xml_shapes = []

def get_shapes(dom):
    for node in dom.childNodes:
        if node.nodeName == "topic":
            x = node.getAttribute("x")
            y = node.getAttribute("y")
            shape = node.getAttribute("shape")
            xml_shapes.append({'x': x, 'y': y, 'shape': shape})
        if node.parentNode.nodeName == 'topic':
            xml_shapes.append({'x1': node.getAttribute("x"),
                               'y1': node.getAttribute("y"),
                               'x2': node.parentNode.getAttribute("x"),
                               'y2': node.parentNode.getAttribute("y"),
                               'shape': 'connection'})
        if node.hasChildNodes():
            get_shapes(node)
    return xml_shapes
