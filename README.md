# SpringBoot-RabbitMQ

### AMQP(Advanced Message Queuing Protocol)

AMQP เป็นโปรโตคอลที่ใช้ในการรับส่งข้อความระหว่างแอพพลิเคชันที่มีน้ำหนักเบา คุณสมบัติที่กำหนดของ AMQP คือ การจัดคิวของข้อความ(queuing) การกำหนดเส้นทาง(routing) แบบจุดต่อจุด(point-to-point) หรือแบบแพร่กระจาย (publish-and-subscribe) ที่มีความน่าเชื่อถือและปลอดภัย

#### AMQP Priority

โปรโตคอล AMQP รองรับลำดับความสำคัญของ Queue สูงสุด 10 ระดับโดยเริ่มต้นที่ 0 มีลำดับความสำคัญต่ำสุดและ 9 มีลำดับความสำคัญสูงสุด ลำดับความสำคัญของข้อความถูกกำหนดโดย  publisher/producer โดยใช้ header ในการระบุ

### RabbitMQ คืออะไร

RabbitMQ คือ Message Broker ตัวกลางในการรับส่งข้อความที่มีอัตราการส่งข้อมูลระดับสูง ที่ใช้ AMQP



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
