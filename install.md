# Install

## Scala v2.11 설치
- Spark 2.1.0(사내 설치 버전)의 Scala API가 Scala 2.11.x를 지원함
- required : jdk 7+

Ubuntu
```
wget https://downloads.lightbend.com/scala/2.11.11/scala-2.11.11.tgz
tar xvf scala-2.11.11.tgz
sudo mv scala-2.11.11 /usr/lib
sudo ln -f -s /usr/lib/scala-2.11.1 /usr/lib/scala
sudo vi /etc/profile.d/scala.sh
    export SCALA_HOME=/usr/lib/scala
    export PATH=$PATH:/usr/lib/scala/bin
source /etc/profile.d/scala.sh
```
Mac
```
brew search scala
brew install scala@2.11
echo 'export PATH="/usr/local/opt/scala@2.11/bin:$PATH"' >> .zshrc
```
