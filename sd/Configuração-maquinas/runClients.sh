
#!/bin/bash

run ()
{
    xfce4-terminal \
     --tab --hold -e "bash -c 'java Simulation.client.PilotClient '" -T "Pilot" \
     --tab --hold -e "bash -c 'java Simulation.client.HostessClient '" -T "Hostess" \
     --tab --hold -e "bash -c 'java  Simulation.client.PassengerClient 0'" -T "Pass 0" \
     --tab --hold -e "bash -c 'java  Simulation.client.PassengerClient 1'" -T "Pass 1" \
     --tab --hold -e "bash -c 'java  Simulation.client.PassengerClient 2'" -T "Pass 2" \
     --tab --hold -e "bash -c 'java  Simulation.client.PassengerClient 3'" -T "Pass 3" \
     --tab --hold -e "bash -c 'java  Simulation.client.PassengerClient 4'" -T "Pass 4" \
     --tab --hold -e "bash -c 'java  Simulation.client.PassengerClient 5'" -T "Pass 5" 
   
     
     
     
}


#command to compile
#javac $(find . -name "*.java") -Xlint:unchecked

for i in $(seq 1 1)
	do
	    echo -e "\nRun n.o " $i
	    num_proc=$(ps -aux | grep clients | wc -l)
	    
	    run
	    
	    while [ $(ps -aux | grep clients | wc -l) -gt $num_proc ]; do
		sleep 0.1
	    done
	done

