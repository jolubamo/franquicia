# Apirest franquicias
Para desplegar la aplicación desde un entorno local solo hay que tener en cuenta tener instalado lombok en el entorno del springboot y hacer un maven update de manera preventiva

## Endpoints expuestos
- Agregar nueva franquicia:
  - Metodo: POST  
  - Url: http://localhost:8080/franquicia  
  - Body: json del objeto franquicia  
  {  
    "nombre":"nombre de ejemplo"  
  }  
- Agregar nueva sucursal:  
  - Metodo: POST  
  - Url: http://localhost:8080/sucursal  
  - Body: json del objeto sucursal  
  {  
    "nombre":"nombre de ejemplo",  
    "franquicia":{  
      "id":1  
    }  
  }  
- Agregar nuevo producto:  
  - Metodo: POST  
  - Url: http://localhost:8080/producto  
  - Body: json del objeto producto  
  {  
    "nombre":"nombre de ejemplo",  
    "sucursal":{  
      "id":1  
    }  
  }
- Eliminar producto:  
  - Metodo: DELETE  
  - Url: http://localhost:8080/producto/{idProducto}  
- Modificar el stock de un producto:  
  - Metodo: PUT  
  - Url: http://localhost:8080/producto/stock
  - Body: json del objeto producto  
  {  
    "id":1,  
    "stock":1  
  }
- Mostrar cual es el producto que mas stock tiene por sucursal para una franquicia puntual(si hay 2 o mas productos con mismo stock en una misma sucursal, mostrara todos):  
  - Metodo: GET  
  - Url: http://localhost:8080/producto/mayor-stock/{franquiciaId}  
- Actualizar el nombre de una franquicia:
  - Metodo: PUT  
  - Url: http://localhost:8080/franquicia/nombre  
  - Body: json del objeto franquicia  
  {  
    "id":1,  
    "nombre":"nombre de ejemplo"  
  }  
- Actualizar el nombre de una sucursal:  
  - Metodo: PUT  
  - Url: http://localhost:8080/sucursal/nombre  
  - Body: json del objeto sucursal  
  {  
    "id":1,  
    "nombre":"nombre de ejemplo",   
  }  
- Actualizar el nombre de un producto:  
  - Metodo: PUT  
  - Url: http://localhost:8080/producto/nombre  
  - Body: json del objeto producto  
  {  
    "id":1,  
    "nombre":"nombre de ejemplo",  
  }
