# SpringBoot-RabbitMQ

### RabbitMQ คืออะไร

RabbitMQ คือ Message Broker ตัวกลางในการรับส่งข้อความที่มีอัตราการส่งข้อมูลระดับสูง ที่ใช้ AMQP (Advanced Message Queuing Protocol)



<p align="center">
  <img  src="https://user-images.githubusercontent.com/15135199/81209714-16c82480-8ffb-11ea-9500-56fa68b039c6.png">
</p>


### ในระบบการส่งข้อความใด ๆ มีองค์ประกอบที่เกี่ยวข้อง 3 ประการ ได้แก่

1. Producer (ผู้ส่ง)
2. Consumer (ผู้รับ)
3. Queue or Topic

### ประเภทของ Exchange 

1. Direct Exchange
2. Fanout Exchange
3. Topic Exchange
4. Headers Exchange
5. Default(Nameless)

### Durability

1. durable
2. Transient
