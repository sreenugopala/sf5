Issues

1. When port 8080 is already in use, need to
C:\Users\sreen>netstat -aon | findstr 8080
  TCP    0.0.0.0:8080           0.0.0.0:0              LISTENING       8432
  TCP    [::]:8080              [::]:0                 LISTENING       8432

C:\Users\sreen>taskkill /PID 8432 /f
SUCCESS: The process with PID 8432 has been terminated.