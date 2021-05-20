#!/bin/bash



#number of passenger must be equal  to the number  given to class DepAirp_server
run ()
{
    xfce4-terminal \
     --tab  -e "bash -c 'java Simulation.server.DepartAirp.DepAirp_server 11 5 8'" -T "DepAirp_server" \
     --tab  -e "bash -c 'java Simulation.server.DestinationAirp.DestAirp_server '" -T "DestAirp_server" \
     --tab  -e "bash -c 'java Simulation.server.Plane.Plane_server '" -T "Plane_Server" \
     --tab  -e "bash -c 'java Simulation.client.PilotClient '" -T "Pilot" \
     --tab  -e "bash -c 'java Simulation.client.HostessClient '" -T "Hostess" \
     --tab  -e "bash -c 'java  Simulation.client.PassengerClient 0'" -T "Pass 0" \
     --tab  -e "bash -c 'java  Simulation.client.PassengerClient 1'" -T "Pass 1" \
     --tab  -e "bash -c 'java  Simulation.client.PassengerClient 2'" -T "Pass 2" \
     --tab  -e "bash -c 'java  Simulation.client.PassengerClient 3'" -T "Pass 3" \
     --tab  -e "bash -c 'java  Simulation.client.PassengerClient 4'" -T "Pass 4" \
     --tab  -e "bash -c 'java  Simulation.client.PassengerClient 5'" -T "Pass 5" \
     --tab  -e "bash -c 'java  Simulation.client.PassengerClient 6'" -T "Pass 6" \
     --tab  -e "bash -c 'java  Simulation.client.PassengerClient 7'" -T "Pass 7" \
     --tab  -e "bash -c 'java  Simulation.client.PassengerClient 8'" -T "Pass 8" \
     --tab  -e "bash -c 'java  Simulation.client.PassengerClient 9'" -T "Pass 9" \
     --tab  -e "bash -c 'java  Simulation.client.PassengerClient 10'" -T "Pass 10" 
}


#command to compile
#javac $(find . -name "*.java") -Xlint:unchecked

for i in $(seq 1 1)
	do
	    echo -e "\nRun n.o " $i
	    num_proc=$(ps -aux | grep Simulation | wc -l)
	    
	    run
	    
	    while [ $(ps -aux | grep Simulation | wc -l) -gt $num_proc ]; do
		sleep 0.1
	    done
	done

