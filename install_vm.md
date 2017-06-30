# Vagrant 설치

### Steps
1. VitualBox 설치
    - https://www.virtualbox.org/wiki/Downloads

2. Vagrant 설치
    - https://www.vagrantup.com/downloads.html

3. Vagrant box 추가
    ```sh
    vagrant box add comma/spark ./comma_spark.box
    vagrant box list
    ```

4. vm 생성
- 적당한 디렉토리 생성 > Vagrantfile 복사 > 이동 > vm 시작
    ```
    cp Vagrantfile ./vm/test
    cd ./vm/test
    vagrant up
    ```
5. putty download & setting
- putty 설치 > vagrant에서 표시된 ssh 정보로 접속
- Windows : Line of scrollback : 10000, Windows > Appearance : 폰트 12
