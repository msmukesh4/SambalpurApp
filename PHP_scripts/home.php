<?php
//header('Content-Type: application/json');
// database config
// $server = '...';
// $user = '...';
// $root = '...';
// $password = '...';

// creating an instance of sqlite
/*$mysqli = new sqli($server,$user,$password,$root);
if ($mysqli->maxdb_connect_errno) {
	# code...
	$connection = array('Connection' => 'failure' );
	echo json_encode($connection);
}else{
	// Extract the title for the home from database
	$titleList = $mysqli->query(SELECT <column1>,<column2> FROM <tableName>);
	// Starting list from the start
	$titleList->data_seek(0);

	// Iteration
	while($row = $titleList->fetch_assoc()){
		// conditional operators to chech the criteria
		if($row['<column1>']==$....){
			success 
		}
	}
}*/

$home_title = array('tourism','shopping','festivals','resturant & hotels','movies','taxi & travel','doctor contacts','emergency','petrol pump');

$title = array('title' => $home_title);
echo json_encode($title);
	
?>