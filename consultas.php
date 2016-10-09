<?php
$servername = "localhost";
$username = "client";
$password = "12345";
$bd = "mamaaway";

// Create connection
if (isset($_POST["JSON_ENVIAR"])){
    $datos = $_POST["JSON_ENVIAR"];
    //$prueba = json_decode("");
    //$data = json_decode();
    //$datos = '{"fun":"tuto"}';
    $obj = json_decode($datos);
    //$obj = json_decode($data);
    try {
    $conn = new mysqli($servername, $username, $password,$bd);

    // Check connection
    if ($conn->connect_error) {
        die("Connection failed: " . $conn->connect_error);
    }  
    $consulta = "";
    $op = 0; // 0 select , 1 insert/update/delete
    // Generar sqls
    // fun = tuto consulta tutoriales
    // fun = consejo consulta consejos
    // fun = con_lista consulta la lista de tareas
    // fun = ins_lista inserta elemento en la lista
    // fun = upt_lista actualizar el idusuario (check se ha comprado) y cuanto se ha gastado
    // fun = con_tareas consulta las tareas
    // fun = upt_check_tareas actualizar se
    $funcion = $obj->{'fun'};
    switch($funcion){
        case "tuto": 
            $consulta = "select * from tutoriales";
        break;
		
        case "consejo": 
            $consulta = "select * from consejos";
        break;
		
        case "con_lista":
            $consulta = "select * from listacompra where IDusuario = '".$obj->{'IDUsuario'}."'";
        break;  
		
        case "ins_lista":
            $consulta = "insert into listacompra values(,'".$obj->{'texto'}."','".$obj->{'comprado'}."','".$obj->{'IDusuario'}."')";
            $op = 1;
        break;
		
        case "upt_lista":
            $consulta = "update listacompra set texto='".$obj->{'texto'}."', comprado='".$obj->{'comprado'}."' where IDUsuario = '".$obj->{'IDUsuario'}."'";
            $op = 1;
        break;
		
        case "del_lista":
             $consulta = "delete from listacompra where IDusuario = '".$obj->{'IDUsuario'}."'";
             $op = 1;
        break;
        
        case "con_compartida":
            $consulta = "select * from listacompracompartida where IDUsuario = '".$obj->{'IDUsuario'}."'";
        break;   
		
        case "ins_compartida":
            $consulta = "insert into listacompracompartida  VALUES (,'".$obj->{'texto'}."' , '".$obj->{'IDusuario'}."', '".$obj->{'dinero'}."', '".$obj->{'IDpiso'}."')";
            $op = 1;
        break;
		
        case "upt_compartida":
            $consulta = "update listacompracompartida set IDUsuario = '".$obj->{'IDUsuario'}."' , dinero = '".$obj->{'dinero'}."'";
            $op = 1;
        break;
		
        case "del_compartida":
            $consulta = "delete from listacompracompartida where IDUsuario = '".$obj->{'IDUsuario'}."'";
            $op = 1;
        break;
            
        case "con_tareas": 
            $consulta = "select * from tareas where IDPiso = '".$obj->{'IDPiso'}."' and IDsemana = '".$obj->{'IDSemana'}."' order by IDtareaSemana";
        break;
		
        case "ins_tareas":
            $consulta = "insert into tareas VALUES('".$obj->{'IDtarea'}."' , '".$obj->{'IDsemana'}."' , '".$obj->{'IDusuario'}."' , '".$obj->{'IDtareasemana'}."')";
            $op = 1;
        break;
		
        case "upt_tareas":
            $consulta = "update tareas set IDtarea = '".$obj->{'IDtarea'}."', IDsemana = '".$obj->{'IDsemana'}."', IDusuario = '".$obj->{'IDusuario'}."', IDtareasemana = '".$obj->{'IDtareasemana'}."' where IDPiso = '".$obj->{'IDPiso'}."' and IDtareasemana = '".$obj->{'IDtareasemana'}."')";
            $op = 1;
        break;
		
        case "del_tareas":
            $consulta = "delete from tareas where IDPiso = '".$obj->{'IDPiso'}."' and IDsemana = '".$obj->{'IDSemana'}."'";
            $op = 1;
        break;
            
        case "upt_check_tareas": 
            $consulta = "update tareas set realizada = 1 where IDPiso = '".$obj->{'IDPiso'}."' and IDtareaSemana = '".$obj->{'IDtareaSemana'}."'";
            $op = 1;
        break;
        
		case "con_tareasdesc":
            $consulta = "select * from tareasdescripcion where IDtarea = '".$obj->{'IDtarea'}."'";
        break;
        
		case "ins_tareasdesc":
            $consulta = "insert into tareasdescripcion VALUES(,'".$obj->{'descripcion'}."')";
            $op = 1;
        break;
        
		case "upt_tareasdesc":
            $consulta = "update tareasdescripcion set descripcion = '".$obj->{'descripcion'}."'";
            $op = 1;
        break;
        
		case "del_tareasdesc":
            $consulta = "delete from tareasdescription where IDtarea = '".$obj->{'IDtarea'}."'";
            $op = 1;
        break;
            
        case "con_login":
	    $consulta = "select * from login where IDusuario = '".$obj->{'IDusuario'}."'";
        break;
            
	    case "ins_login": 
	    $consulta = "insert into login VALUES(,'".$obj->{'username'}."', '".$obj->{'mail'}."', '".$obj->{'contra'}."')";
	    $op = 1;
	    break;
	
	    case "ins_relpisos":
	    $consulta = "insert into relpisos VALUES('".$obj->{'IDusuario'}."', '".$obj->{'IDpiso'}."')";
	    $op = 1;
	    break;
	
	    case "ins_piso":
	    $consulta = "insert into pisos VALUES(,'".$obj->{'nombrepiso'}."')";
	    break;
    }

    switch($op){
        case 0:
            if($result = $conn->query($consulta)){
                if ($result->num_rows > 0) {
                    // output data of each row
                    while($row = $result->fetch_assoc()) {
                       // echo "IDtutorial: " . $row["IDtutorial"]. " - titulo: " . $row["titulo"]. " - resumen: " . $row["resumen"]. " - cuerpo: " . $row["cuerpo"]. "<br>";
                    //    echo $row;
                        $rows[] = $row;
                     // echo substr(json_encode($rows), 1,json_encode($rows).length-1);  

                    }
                  //echo substr(json_encode($rows),1,-1); 
                    //return substr(json_encode($rows),1,-1);
                    echo '{"respuesta":'.json_encode($rows)."}"; 
                    return '{"respuesta":'.json_encode($rows)."}"; 
                }
            }
        break;
        case 1:
            if ($conn->query($sql) === TRUE) {
                return true;
            } else {
                return false;
            }

        break;
    }

    mysqli_close($conn);
    }catch(Exception $e){

    }
}
?>