# Bank-Data-Visualization
본 프로젝트는 예금보험공사에서 제공하는 부실저축은행 데이터를 활용하여 저축은행의 현황과 경영 정보를 분석하기 쉽도록 의미 있는 시각적 표현을 제공하는 것을 목표로 합니다.

[배포주소](http://data.doget.site)

## 개요
- 예금보험공사에서 제공하는 '부실저축은행DB'를 기반으로 과거의 신규 대출, 예금 및 적금 현황, 재무상태, 손익 데이터를 수집하고 분석
- 데이터 가시화 시스템을 개발하여 수집한 데이터를 시각적으로 효과적으로 표현
- 저축은행의 기간별 현황과 경향성을 직관적으로 파악하고, 이를 학술적 연구나 정책 결정에 활용할 수 있는 정보를 제공

## 기능
데이터 전처리: 시각화를 위해 은행 데이터를 정리하고 전처리
차트 시각화: 선 그래프, 막대 그래프, 분산도 등 다양한 차트를 생성하여 데이터의 다양한 측면을 시각화

## 기술스택
- Front-end : React.js, Bootstrap
- Back-end : Servlet, MyBatis
- Database : Oracle
- Server : Oracle Cloud

## 시스템 아키텍처
![아키텍처](https://user-images.githubusercontent.com/106823684/236988526-f4788b30-f3f9-4c15-bf0b-69335d387ad2.png)

## 데이터
1. 여신/수신 현황: 1993~2012 20년간 데이터 분석 및 시각화
  - 여신: 102,453건
  - 수신: 1,322,285건
2. 재무현황: 2000~2012 12년간 데이터 시각화
  - 재무상태표 2000년 11월 ~ 2012년 9월
  - 손익계산서 2000년 11월 ~ 2012년 12월
![데이터](https://user-images.githubusercontent.com/106823684/236988414-e7fed38d-d2c0-441b-8278-cf9df3ef907b.png)

## 화면
### 메인
![image](https://user-images.githubusercontent.com/106823684/236988851-36c197b1-9d0a-4603-b187-72a2a51a2c51.png)

### 대출정보
![image](https://user-images.githubusercontent.com/106823684/236988902-07b78241-2101-4926-b1b0-5225b429ae67.png)
![image](https://user-images.githubusercontent.com/106823684/236989696-c60d9cc4-60a0-47b3-aee3-15debcbae771.png)

### 예금정보
![image](https://user-images.githubusercontent.com/106823684/236988992-d8f09323-1e46-4d15-8ba3-759ae4b64336.png)
![image](https://user-images.githubusercontent.com/106823684/236989652-008c30c7-c390-468f-818a-fe38e0a21c66.png)

### 손익계산서
![image](https://user-images.githubusercontent.com/106823684/236989046-a433423b-7490-48af-a480-6a0171eed14d.png)

### 재무상태표
![image](https://user-images.githubusercontent.com/106823684/236989103-102c8d5a-8e74-429b-9907-9a5d3632a6d6.png)
