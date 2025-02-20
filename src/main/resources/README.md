El comportamiento de la generación de tablas depende de la propiedad spring.jpa.hibernate.ddl-auto:

Valor	    | Descripción
____________|_____________________________________________________________________________________
none	    | No cambia la base de datos. Debes crear las tablas manualmente.
____________|_____________________________________________________________________________________
validate    |Solo valida si la estructura de la base de datos coincide con las entidades.
            |No crea ni modifica tablas.
____________|_____________________________________________________________________________________
update	    |Modifica la estructura de la base de datos sin borrar datos existentes.
____________|_____________________________________________________________________________________
create	    |Crea las tablas en cada inicio de la aplicación. Borra los datos existentes.
____________|_____________________________________________________________________________________
create-drop	|Igual que create, pero elimina las tablas al detener la aplicación.
____________|_____________________________________________________________________________________


MEJORAS:
EN LA CAPA DE INFRASTRUCTURE AGREGAR UNA CARPETA DE IN  Y OUT
METER COSAS DE DDD