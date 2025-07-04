1. 주택프로젝트 생성

```
http :8088/housingProjects \
  name="개포동 재개발 A단지" \
  location="서울시 강남구 개포동 123-45" \
  completionDate="2025-12-31" \
  isCompletion:=false
```

2. 준공처리
```
http PUT :8088/housingProjects/1/processcompletion isCompletion=true
```

3. 주택 공급 계획 수립
```
http :8088/houseSupplies \
  houseName="개포동 재개발 A단지 101동" \
  houseLocation="서울시 강남구 개포동 123-45 (101동)" \
  supplyStatus="PLANNED" \
  projectName="개포동 재개발 A단지" \
  manager="김담당" \
  recruitmentCount:=120 \
  housingProjectId:='{"id": 1}' \
  isApprove:=false
```

4. 공급계획심사
```
http PUT :8088/houseSupplies/2/examinesupplyplan isApprove=true
```

5. 청약신청