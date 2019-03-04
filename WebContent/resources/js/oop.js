/*
 * 상속
 * */ 
function People(name,age,gender,job){
	this.name = name;
	this.age = age;
	this.gender = gender;
	this.job = job;
}

People.prototype.setName =name=>{this.name = name;};//아규먼트에 값이 들어있으면 괄호를 지운다. 
People.prototype.setAge =age=>{this.age = age;};
People.prototype.setGender =gender=>{this.gender = gender;};
People.prototype.setJob =job=>{this.job = job;};
People.prototype.getName =()=>{return this.name;};
People.prototype.getAge =()=>{return this.age;};
People.prototype.getGender =()=>{return this.gender;};
People.prototype.getJob =()=>{return this.job;};
//은닉 개터세터 클로져
//상속 프로토타입
//추형 객체리터럴 바로 제이슨 던진거 객체로 바로 표현
//다형 getPrototypeOf 오버라이딩 1개 오버로딩, 제네릭 내장. 

function Customer(grade, custNo){//위에서 중복된거 지움.
	People.apply(this, arguments);
	this.grade = grade;
	this.custNo = custNo;
}

Customer.prototype = new People();

Customer.prototype.setName =name=>{
	Object.getPrototypeOf(Customer.prototype).setName('닉네임:  '+name);
}
//{this.name = '닉네임'+name;}; 자바문법 오버라이딩 다형성 완성

Customer.prototype.setGrade =grade=>{this.grade = grade;};
Customer.prototype.setCustNo =custNo=>{this.custNo = custNo;};
Customer.prototype.getGrade =()=>{return this.grade;};
Customer.prototype.getCustNo =()=>{return this.custNo;};


var test ={
		main:function(){
		let cus = new Customer();		
		cus.setName('홍길동');
		cus.setAge('20세');
		cus.setGender('남자');
		cus.setJob('개발자');
		cus.setGrade('3급');
		cus.setCustNo('1212');
		alert('<고객정보>\n'+ cus.getName() +'\n'+ cus.getAge() +'\n'+ cus.getGender() +'\n'+ cus.getJob() +'\n'+ cus.getGrade() +'\n'+ cus.getCustNo());
	}};
//::객체리터널:: 속성이 제거된 함수 기능만 남은 객체 , 펑션과 펑션 사이에 속성이 저장되는데 그 공간을 지움  






