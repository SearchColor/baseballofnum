<p align="center">
<img src="https://lh3.googleusercontent.com/proxy/QUQqPUqt6i3ayKtW7WKp7VkyLWIcuzM3wnU633FZaywlDdIhtQ4YOMVKxJeV1nv-4TDtFwU9HgRrWgwdl6TpZRFdDPxkC63cc5j5AwA02Lv_T0nd72BRqYz8KaZ0KUBgWLYJO9qzKG4" width="20%" height="20%" title="px(픽셀) 크기 설정" alt="Calculator"></img>
</p>

# baseballofnum Project
설정한 자리수의 숫자를 맞추는 게임.

>- ## Game Rule
>1. 입력한값과 정답을 비교하여 자리와 숫자가 맞으면 strike
>2. 숫자만 맞으면 ball
>3. 자리와 숫자가 둘다 맞지않으면 out
>4. 입력한값의 strike,ball,out 을 가지고 추론하여 최대한 적은 게임횟수로 정답을 맞추는게임
>- ## 구현한 기능
>1. 난이도 설정(자리수)
>2. 중복되지않는 숫자의 정답 생성
>3. 입력받은값과 정답을 비교하여 strike , ball 계산
>4. 힌트
>4. 게임 기록
>5. 프로그램 종료기능
>---
>- ## class 설계
>- Main class : 프로그램 전반적인 부분을 담당
>- ->자리수 설정 , 게임 시작 , 게임 기록 , 게임 종료
>- BaseballGame class : 게임 기능을 담당
>- ->정답 생성 , 포인트 계산(strike,ball) , 힌트 생성 및 출력
>- display : 게임 옵션화면 , 게임화면 담당
>- -> optionDisplay , baseballGameDisplay
>- <img src="http://octodex.github.com/images/minion.png" alt="Minion" />
>```java
>while(true){ //반복적으로 계산을 하기위한 전체 반복문
>
>      while(true){ //intput 반복문
>        // input data 입력받는 내용
>        // 개별로 입력받아 잘못입력받을시 그지점에서 다시 입력받기위해 반복문으로 구현
>      }
>
>}
>```
>---
> - ## 기능 구현 설계
>> - 자리수 설정 
>>   - main 부에서 game 을 생성할때 설정난이도(자리수)를 매개변수로 대입하여 생성
>>   - 설정된 자리수로 생성된 게임에서 자리수에 따라 정답,strike,ball,hint 등 모든부분에 연결
>> - 중복되지않는 숫자의 정답 생성 
>>   - Collection 중 중복을 허용하지않는 Set 을 사용하여 배열생성
>>   - Math.random()를 이용하여 랜덤수 생성
>>   - 입력한값의 숫자뿐아니라 자리도 비교해야하니 배열의 순서가 보장되는 List 로 변환
>>   - Collection.shuffle() 사용하여 생성 마무리.
>> - 입력받은값과 정답을 비교
>>   - 입력한값의 숫자를 하나씩 List 에 대입
>>   - 정답 List 와 비교하여 하여 strike , ball 계산
>> - 힌트
>>   - 게임시도 횟수와 자리수에 따라서 추가 힌트를 제공
>> - 게임 기록
>>   - main 부에 Collection Map 을 생성하여 게임 기록을 저장
>> - 프로그램 종료기능
>>   - main class 안의 while 문을 break 하여 구현
>>
>> 자세한 코드의 설명은 코드내에 주석을 확인
>>
<a href="[http://taewan.kim](https://velog.io/@skykid/2024.10.22-TIL#methods)">velog</a>



