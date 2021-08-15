
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
     --tab --hold -e "bash -c 'java  Simulation.client.PassengerClient 5'" -T "Pass 5" \
      --tab --hold -e "bash -c 'java  Simulation.client.PassengerClient 6'" -T "Pass 6" \
     --tab --hold -e "bash -c 'java  Simulation.client.PassengerClient 7'" -T "Pass 7" \
     --tab --hold -e "bash -c 'java  Simulation.client.PassengerClient 8'" -T "Pass 8" \
     --tab --hold -e "bash -c 'java  Simulation.client.PassengerClient 9'" -T "Pass 9" \
     --tab --hold -e "bash -c 'java  Simulation.client.PassengerClient 10'" -T "Pass 10" \
     --tab --hold -e "bash -c 'java  Simulation.client.PassengerClient 11'" -T "Pass 11"\
      --tab --hold -e "bash -c 'java  Simulation.client.PassengerClient 12'" -T "Pass 12" \
     --tab --hold -e "bash -c 'java  Simulation.client.PassengerClient 13'" -T "Pass 13" \
     --tab --hold -e "bash -c 'java  Simulation.client.PassengerClient 14'" -T "Pass 14" \
     --tab --hold -e "bash -c 'java  Simulation.client.PassengerClient 15'" -T "Pass 15" \
     --tab --hold -e "bash -c 'java  Simulation.client.PassengerClient 16'" -T "Pass 16" \
     --tab --hold -e "bash -c 'java  Simulation.client.PassengerClient 17'" -T "Pass 17"\
      --tab --hold -e "bash -c 'java  Simulation.client.PassengerClient 18'" -T "Pass 19" \
     --tab --hold -e "bash -c 'java  Simulation.client.PassengerClient 19'" -T "Pass 18" \
     --tab --hold -e "bash -c 'java  Simulation.client.PassengerClient 20'" -T "Pass 20" 
     
     
     
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

