# SpringBoot-RabbitMQ

### AMQP(Advanced Message Queuing Protocol)

AMQP เป็นโปรโตคอลที่ใช้ในการรับส่งข้อความระหว่างแอพพลิเคชันที่มีน้ำหนักเบา คุณสมบัติที่กำหนดของ AMQP คือ การจัดคิวของข้อความ(queuing) การกำหนดเส้นทาง(routing) แบบจุดต่อจุด(point-to-point) หรือแบบแพร่กระจาย (publish-and-subscribe) ที่มีความน่าเชื่อถือและปลอดภัย

#### AMQP Priority

โปรโตคอล AMQP รองรับลำดับความสำคัญของ Queue สูงสุด 10 ระดับโดยเริ่มต้นที่ 0 มีลำดับความสำคัญต่ำสุดและ 9 มีลำดับความสำคัญสูงสุด ลำดับความสำคัญของข้อความถูกกำหนดโดย  publisher/producer โดยใช้ header ในการระบุ

### RabbitMQ คืออะไร

RabbitMQ คือ Message Broker ตัวกลางในการรับส่งข้อความที่มีอัตราการส่งข้อมูลระดับสูง ที่ใช้โปรโตคอล AMQP

<p align="center">
  <img  src="https://www.rabbitmq.com/img/tutorials/intro/hello-world-example-routing.png">
</p>

#### RabbitMQ Priority

RabbitMQ รองรับลำดับความสำคัญที่ 1 ถึง 255 แนะนำให้ใช้ค่าระหว่าง 1 ถึง 10 Priority มีมาให้ตั้งแต่ version 3.5 ขึ้นไปหากใช้ version ที่ต่ำกว่าจะต้องติดตั้ง plugin rabbitmq-priority-queue
เพิ่ม (https://github.com/rabbitmq/rabbitmq-priority-queue)

### ประเภทของ Exchange 

1. <b>Direct Exchange : </b> จะส่ง message ไปยัง Queue โดยตรงด้วย message routing key.
2. <b>Fanout Exchange : </b> จะส่ง message กระจายไปทุก Queue ที่เชื่อมโยงอยู่กัน exchange.
3. <b>Topic Exchange : </b> จะส่ง message ไปยัง Queue โดยขึ้นอยู่กับ matching ระหว่าง message routing key และ pattern ที่เชื่อมโยง Queue กับ Exchange.
4. <b>Headers Exchange : </b>
5. <b>Default(Nameless) : </b>

### Durability

#### 1. durable

เก็บข้อมูลหว้ใน disk

#### 2. Transient

เก็บข้อมูลหว้ใน ram ข้อมูลจะหายเมื่อมีการ restart server
