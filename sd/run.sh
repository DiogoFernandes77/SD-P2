#!/bin/bash



#number of passenger must be equal  to the number  given to class DepAirp_server
run ()
{
    xfce4-terminal \
     --tab --hold -e "bash -c 'java Simulation.server.LogPackage.Logger_Server 2 2 3'" -T "Logger" \
     --tab --hold -e "bash -c 'java Simulation.server.DepartAirp.DepAirp_server 2 2 3'" -T "DepAirp_server" \
     --tab --hold -e "bash -c 'java Simulation.server.DestinationAirp.DestAirp_server '" -T "DestAirp_server" \
     --tab --hold -e "bash -c 'java Simulation.server.Plane.Plane_server '" -T "Plane_Server" \
     --tab --hold -e "bash -c 'java Simulation.client.PilotClient '" -T "Pilot" \
     --tab --hold -e "bash -c 'java Simulation.client.HostessClient '" -T "Hostess" \
     --tab --hold -e "bash -c 'java  Simulation.client.PassengerClient 0'" -T "Pass 0" \
     --tab --hold -e "bash -c 'java  Simulation.client.PassengerClient 1'" -T "Pass 1" \
     --tab --hold -e "bash -c 'java  Simulation.client.PassengerClient 0'" -T "Pass 2" \
     --tab --hold -e "bash -c 'java  Simulation.client.PassengerClient 1'" -T "Pass 3" \
     --tab --hold -e "bash -c 'java  Simulation.client.PassengerClient 0'" -T "Pass 4" \
     --tab --hold -e "bash -c 'java  Simulation.client.PassengerClient 1'" -T "Pass 5" 
   
     
     
     
}


#command to compile
#javac $(find . -name "*.java") -Xlint:unchecked

for i in $(seq 1 1)
	do
	    echo -e "\nRun n.o " $i
	    num_proc=$(ps -aux | grep airport | wc -l)
	    
	    run
	    
	    while [ $(ps -aux | grep airport | wc -l) -gt $num_proc ]; do
		sleep 0.1
	    done
	done

