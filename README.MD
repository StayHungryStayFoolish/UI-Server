# READ ME

## Add Liquibase

1. Add Dependencies

        dependencies {
            liquibaseRuntime "mysql:mysql-connector-java"
            liquibaseRuntime "org.liquibase:liquibase-core"
            liquibaseRuntime "org.liquibase.ext:liquibase-hibernate5:${liquibase_hibernate5_version}"
            liquibaseRuntime sourceSets.main.compileClasspath
        }



## Add MapStruct

1. Add Dependencies

        dependencies {
            implementation "org.mapstruct:mapstruct-jdk8:${mapstruct_version}"
            annotationProcessor "org.mapstruct:mapstruct-processor:${mapstruct_version}"
        }
        
2. Code

    2.1 Create Common Interface

        public interface EntityManpper <D, E> {
                                       
            E toEntity(D dto);
        
            D toDto(E entity);
        
            List<E> toEntity(List<D> dtoList);
        
            List<D> toDto(List<E> entityList);
        }
        
    2.2 Extends Common Interface
    
        @Mapper(componentModel = "spring",uses = {})
        public interface ExampleMapper extends EntityMapper<ExampleDTO, ExampleEntity> {
        
            default ExampleEntity fromId(Long id) {
                if (id == null) {
                    return null;
                }
                ExampleEntity example = new ExampleEntity();
                example.setId(id);
                return example;
            }
        }
        
    2.3 Inject ExampleMapper can use `toDto` and so on. 
    
## Add Lombok

1. Add Dependencies

        dependencies {
            implementation "org.projectlombok:lombok:${lombok_version}"
        }              

2. Install Lombok Plugins

    Open IDEA `Preferences` Plugins,search `lombok` install it.
    
3. Open Settings
    
    ![img](lombok-1.jpg)
    
    ![img](lombok-2.jpg)
    
## Add Proto、GRPC

1. Add Dependencies

        buildscript {
            repositories {
                mavenLocal()
                mavenCentral()
                maven { url "http://repo.spring.io/plugins-release" }
                maven { url "https://plugins.gradle.org/m2/" }
            }
            dependencies {
                classpath "org.springframework.boot:spring-boot-gradle-plugin:${spring_boot_version}"
                classpath 'com.google.protobuf:protobuf-gradle-plugin:0.8.8'
            }
        }
        
        plugins {
            id "com.google.protobuf" version "0.8.8"      
        }

        apply plugin: 'org.springframework.boot'
        apply plugin: 'io.spring.dependency-management'
        
        dependencies {
            
            implementation 'net.devh:grpc-server-spring-boot-starter:2.0.1.RELEASE'
            implementation "io.protostuff:protostuff-core:${protostuff_version}"
            implementation "io.protostuff:protostuff-runtime:${protostuff_version}"
            implementation "com.github.BAData:protobuf-converter:${protobuf_converter_version}"
        
            compileOnly "io.grpc:grpc-netty:${grpc_version}"
            compileOnly "io.grpc:grpc-protobuf:${grpc_version}"
            compileOnly "io.grpc:grpc-core:${grpc_version}"
            compileOnly "io.grpc:grpc-stub:${grpc_version}"
        }    

2. Run Command

        gradle generateProto
        
   Code Position
   
        |-- build
               |-- generated
                        |-- source
                                |-- proto
                                        |-- main
                                            |
                                            |--- grpc
                                            |  
                                            |--- java     

3. use annotation `@net.devh.springboot.autoconfigure.grpc.server.GrpcService` to provide external service

        @GrpcService(ProtoBufferClass.class)
        public ProtoClassService extends ProtoBufferClass.ProtoClassImplBase {
        
               /**
               *  MessageClass <--> JavaDomainClass
               *
               * @Override Method (Proto File Define Method)
               */
               public void methodName (MessageClass.MessageRequest request, StreamObserver<MessageClass.MessageResponse> responseObserver) {
               
               
                    responseObserver.onNext(messageResponse);
                    responseObserver.onCompleted();
               }        
        }      
 
5. Add annotation `@ProtoClass` and `@ProtoFiled` on class and filed.
    
        
        @ProtoClass(ProtobufUser.class)
        public class User {
        
        	@ProtoField
        	private String name;
        	@ProtoField
        	private String password;
        
        	// getters and setters for 'name' and 'password' fields
        	...
        }
        
        // Code for conversion User instance into related protobuf message:
        User userDomain = new User();
        ...
        ProtobufUser userProto = Converter.create().toProtobuf(ProtobufUser.class, userDomain);
        
        // Code for backward conversion:
        User userDomain = Converter.create().toDomain(User.class, userProto);


* Also, you can user other plugins. [GitHub Proto-Stuff](https://github.com/protostuff/protostuff)

## Add Liquibase
