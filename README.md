# 

## Model
www.msaez.io/#/123912988/storming/cde9a39c80798ffc8109347c68bbb47e

## Before Running Services
### Make sure there is a Kafka server running
```
cd kafka
docker-compose up
```
- Check the Kafka messages:
```
cd infra
docker-compose exec -it kafka /bin/bash
cd /bin
./kafka-console-consumer --bootstrap-server localhost:9092 --topic
```

## Run the backend micro-services
See the README.md files inside the each microservices directory:

- supplyplan
- receipt
- notification
- winningresult
- resident
- contract


## Run API Gateway (Spring Gateway)
```
cd gateway
mvn spring-boot:run
```

## Test by API
- supplyplan
```
 http :8088/housingProjects id="id"name="name"location="location"completionDate="completionDate"isCompletion="isCompletion"
 http :8088/houseSupplies id="id"HousingProjectId := '{"id": 0}'houseName="houseName"houseLocation="houseLocation"SupplyStatus = "PLANNED"projectName="projectName"manager="manager"recruitmentCount="recruitmentCount"
```
- receipt
```
 http :8088/announcements id="id"title="title"content="content"houseName="houseName"houseLocation="houseLocation"applyStartDate="applyStartDate"applyEndDate="applyEndDate"moveInStartDate="moveInStartDate"moveInEndDate="moveInEndDate"eligibilityCriteria="eligibilityCriteria"
 http :8088/subscriptions id="id"AnnouncementId := '{"id": 0}'houseName="houseName"houseLocation="houseLocation"recipientName="recipientName"documentFile="documentFile"ApplyStatus = "RECEIVED"phoneNumber="phoneNumber"email="email"
```
- notification
```
 http :8088/notifications id="id"name="name"phoneNumber="phoneNumber"email="email"content="content"
```
- winningresult
```
 http :8088/winners id="id"applyName="applyName"phoneNumber="phoneNumber"email="email"WinningStatus = "WON"house="house"location="location"
```
- resident
```
 http :8088/tenants id="id"houseName="houseName"houseLocation="houseLocation"tenantName="tenantName"tenantPhone="tenantPhone"contractStartAt="contractStartAt"contractEndAt="contractEndAt"isMoveIn="isMoveIn"isLeaving="isLeaving"
 http :8088/maintenances id="id"houseName="houseName"houseLocation="houseLocation"isMaintenance="isMaintenance"maintenanceDate="maintenanceDate"
```
- contract
```
 http :8088/contracts id="id"title="title"houseName="houseName"houseLocation="houseLocation"content="content"contractAt="contractAt"contractEndAt="contractEndAt"name="name"phoneNumber="phoneNumber"
 http :8088/extendContracts id="id"document="document"extendEndAt="extendEndAt"isExtend="isExtend"ContractId := '{"id": 0}'TenantId := '{"id": 0}'
```


## Run the frontend
```
cd frontend
npm i
npm run serve
```

## Test by UI
Open a browser to localhost:8088

## Required Utilities

- httpie (alternative for curl / POSTMAN) and network utils
```
sudo apt-get update
sudo apt-get install net-tools
sudo apt install iputils-ping
pip install httpie
```

- kubernetes utilities (kubectl)
```
curl -LO "https://dl.k8s.io/release/$(curl -L -s https://dl.k8s.io/release/stable.txt)/bin/linux/amd64/kubectl"
sudo install -o root -g root -m 0755 kubectl /usr/local/bin/kubectl
```

- aws cli (aws)
```
curl "https://awscli.amazonaws.com/awscli-exe-linux-x86_64.zip" -o "awscliv2.zip"
unzip awscliv2.zip
sudo ./aws/install
```

- eksctl 
```
curl --silent --location "https://github.com/weaveworks/eksctl/releases/latest/download/eksctl_$(uname -s)_amd64.tar.gz" | tar xz -C /tmp
sudo mv /tmp/eksctl /usr/local/bin
```
