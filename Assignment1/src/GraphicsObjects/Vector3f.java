package GraphicsObjects;



public class Vector3f {

	public float x = 0;
	public float y = 0;
	public float z = 0;
	
	// Default constructor
	public Vector3f() {  
		x = 0.0f;
		y = 0.0f;
		z = 0.0f;
	}
	 
	// Initializing constructor
	public Vector3f(float x, float y, float z) { 
		this.x = x;
		this.y = y;
		this.z = z;
	}
	
	 //implement Vector plus a Vector  and comment what the method does  
	public Vector3f PlusVector(Vector3f Additional) { 
		return new Vector3f(this.x + Additional.x, this.y + Additional.y, this.z + Additional.z);
	} 
	
	 //implement Vector minus a Vector  and comment what the method does  
	public Vector3f MinusVector(Vector3f Minus) { 
		return new Vector3f(this.x - Minus.x, this.y - Minus.y, this.z - Minus.z);
	}
	
	//implement Vector plus a Point and comment what the method does  
	public Point3f PlusPoint(Point3f Additional) { 
		return new Point3f(this.x + Additional.x, this.y + Additional.y, this.z + Additional.z);
	} 
	//Do not implement Vector minus a Point as it is undefined 
	
	//Implement a Vector * Scalar  and comment what the method does    ( we wont create Scalar * Vector due to expediency ) 
	public Vector3f byScalar(float scale )
	{
		return new Vector3f(this.x * scale, this.y * scale, this.z * scale);
	}
	
	//implement returning the negative of a Vector  and comment what the method does  
	public Vector3f  NegateVector()
	{
		return new Vector3f(-this.x, -this.y, -this.z);
	}
	
	//implement getting the length of a Vector    and comment what the method does
	public float length()
	{
		return (float) Math.sqrt(x*x + y*y + z*z);
	}
	
	//implement getting the Normal  of a Vector   and comment what the method does
	// Remember that since you just have one vector, this method is returning a normalized vector with a one unity length 
	public Vector3f Normal()
	{
		float len = this.length();
		if (len != 0) {
			return new Vector3f(x/len, y/len, z/len);
		}
		return new Vector3f(0, 0, 0);
	} 
	
	//implement getting the dot product of Vector.Vector and comment what the method does 

	public float dot(Vector3f v)
	{ 
		return this.x * v.x + this.y * v.y + this.z * v.z;
	}
	
	//implement getting the cross product of Vector X Vector and comment what the method does  
	public Vector3f cross(Vector3f v)  
	{ 
		return new Vector3f(
			this.y * v.z - this.z * v.y,
			this.z * v.x - this.x * v.z,
			this.x * v.y - this.y * v.x
		);
	}
 
}
	 
	   

/*

										MMMM                                        
										MMMMMM                                      
 										MM MMMM                                    
 										MMI  MMMM                                  
 										MMM    MMMM                                
 										MMM      MMMM                              
  										MM        MMMMM                           
  										MMM         MMMMM                         
  										MMM           OMMMM                       
   										MM             .MMMM                     
MMMMMMMMMMMMMMM                        MMM              .MMMM                   
MM   IMMMMMMMMMMMMMMMMMMMMMMMM         MMM                 MMMM                 
MM                  ~MMMMMMMMMMMMMMMMMMMMM                   MMMM               
MM                                  OMMMMM                     MMMMM            
MM                                                               MMMMM          
MM                                                                 MMMMM        
MM                                                                   ~MMMM      
MM                                                                     =MMMM    
MM                                                                        MMMM  
MM                                                                       MMMMMM 
MM                                                                     MMMMMMMM 
MM                                                                  :MMMMMMMM   
MM                                                                MMMMMMMMM     
MM                                                              MMMMMMMMM       
MM                             ,MMMMMMMMMM                    MMMMMMMMM         
MM              IMMMMMMMMMMMMMMMMMMMMMMMMM                  MMMMMMMM            
MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM               ZMMMMMMMM              
MMMMMMMMMMMMMMMMMMMMMMMMMMMMM          MM$             MMMMMMMMM                
MMMMMMMMMMMMMM                       MMM            MMMMMMMMM                  
  									MMM          MMMMMMMM                     
  									MM~       IMMMMMMMM                       
  									MM      DMMMMMMMM                         
 								MMM    MMMMMMMMM                           
 								MMD  MMMMMMMM                              
								MMM MMMMMMMM                                
								MMMMMMMMMM                                  
								MMMMMMMM                                    
  								MMMM                                      
  								MM                                        
                             GlassGiant.com */