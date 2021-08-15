#!/bin/bash



#number of passenger must be equal  to the number  given to class DepAirp_server
run ()
{
    xfce4-terminal \
     --tab --hold -e "bash -c 'java Simulation.server.LogPackage.Logger_Server'" -T "Logger" \
     --tab --hold -e "bash -c 'java Simulation.server.DepartAirp.DepAirp_server'" -T "DepAirp_server" \
     --tab --hold -e "bash -c 'java Simulation.server.DestinationAirp.DestAirp_server '" -T "DestAirp_server" \
     --tab --hold -e "bash -c 'java Simulation.server.Plane.Plane_server '" -T "Plane_Server" 
     
    
   
     
     
     
}


#command to compile

#javac $(find . -name "*.java") -Xlint:unchecked

for i in $(seq 1 1)
	do
	    echo -e "\nRun n.o " $i
	    num_proc=$(ps -aux | grep servers | wc -l)
	    
	    run
	    
	    while [ $(ps -aux | grep servers | wc -l) -gt $num_proc ]; do
		sleep 0.1
	    done
	done

