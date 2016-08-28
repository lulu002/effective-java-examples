// Simple test program for service provider framework
package org.effectivejava.examples.chapter02.item01;

public class Test {
	public static void main(String[] args) {
		// Providers would execute these lines
		Services.registerDefaultProvider(DEFAULT_PROVIDER);
		Services.registerProvider("comp", COMP_PROVIDER);
		Services.registerProvider("armed", ARMED_PROVIDER);
		Services.registerProvider("china", China_Provide);
		
		// Clients would execute these lines
		Service s1 = Services.newInstance();
		Service s2 = Services.newInstance("comp");
		Service s3 = Services.newInstance("armed");
		Service s4 = Services.newInstance("china");
		System.out.printf("%s, %s, %s%n", s1, s2, s3);
		
		s1.sayHello();
		s2.sayHello();
		s3.sayHello();
		s4.sayHello();
	}

	private static Provider DEFAULT_PROVIDER = new Provider() {
		public Service newService() {
			return new Service() {
				@Override
				public String toString() {
					return "Default service";
				}

				@Override
				public void sayHello() {
					System.out.println("默认服务提供商");
				}
			};
		}
	};

	private static Provider COMP_PROVIDER = new Provider() {
		public Service newService() {
			return new Service() {
				@Override
				public String toString() {
					return "Complementary service";
				}

				@Override
				public void sayHello() {
					System.out.println("Comp默认服务提供商");

				}
			};
		}
	};

	private static Provider ARMED_PROVIDER = new Provider() {
		public Service newService() {
			return new Service() {
				@Override
				public String toString() {
					return "Armed service";
				}

				@Override
				public void sayHello() {
					System.out.println("Armed提供商");
				}
			};
		}
	};
	
	private static Provider China_Provide =new Provider() {
		
		@Override
		public Service newService() {
			return new Service() {
				@Override
				public String toString(){
					return "china_provide";
				}
				
				@Override
				public void sayHello() {
					// TODO Auto-generated method stub
					System.out.println("china提供商");
				}
			};
		}
	};
}
