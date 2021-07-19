
package arbol;

public class List {
    
    private Node first;  //se puede llamar cabeza, inicio, primero
    
    //Métodos de la lista
    public List()
    {
        first=null;
    }
    
    //determina si la lista no tiene elementos(true) y si tiene (false)
    public boolean isEmpty()
    {
        return first==null;
    }
    
    //AddFirst-- el elemento que adicionemos queda como la cabeza de la lista
    public void AddFirst(Object data)
    {
        if(isEmpty())
            first = new Node(data);
        else
        {
            Node N = new Node(data);   //paso 1
            N.setLink(first);          //paso 2
            first=N;                   //paso 3
        }
    }
    
    @Override
    public String toString()
    {
        String mess="";
        Node aux = first;  //paso 1.
        
        while(aux!=null)  //paso 2.
        {
            mess= mess + aux.getData() + "\n"; //paso 2.1
            aux = aux.getLink();                //paso 2.2
        }
        return mess;
    }
    
    public Node Last()
    {
        Node aux = first, previuos=null;
        while(aux!=null)
        {
            previuos=aux;
            aux=aux.getLink();
        }
        return previuos;
    }
    //AddLast, la informacion la guarda siempre al final, quedando este de último.
    public void AddLast(Object data)
    {
        if(isEmpty())
            AddFirst(data);
        else
        {
            Node last = Last(); //paso 1
            Node N = new Node(data); //paso 2
            last.setLink(N);  //paso 3.            
        }
    }
    
    public Node Previuos(Object search)
    {
        Node aux = first, previuos=null;
        //busco por el atributo que lo identifica de forma unica
        while(aux!=null && (aux.getData())!= search)
        {
            previuos = aux;
            aux=aux.getLink();
        }
        if (aux!=null)
            return previuos;
        else
            return null;
    }
    
    public int size()
    {
        Node aux = first;
        int counter = 0;
        while(aux!=null)
        {
            counter++;
            aux = aux.getLink();
        }
        return counter;
    }
    
    public boolean RemoveFirst()
    {
        
        if(!isEmpty())
        {
            Node aux = first;
            first = first.getLink();
            aux=null;
            return true;
        }
        return false;
    }
    
    public boolean RemoveLast()
    {
        if(!isEmpty())
        {
            Node last = Last();
            Node previuos = Previuos(last.getData());
            if(previuos == null)
                first = null;
            else
            {
                previuos.setLink(null);
                last = null;
            }
            return true;            
        }
        return false;
    }
    
    public void Add(Object data, int pos)
    {
        if(pos==1)
            AddFirst(data);
        else
        {
            if (pos==(size() + 1))
                AddLast(data);
            else
            {
                Node aux = first;
                int counter = 1;
                while(counter<pos)
                {
                    counter++;
                    aux=aux.getLink();
                }
                Node N = new Node(data);
                N.setLink(aux);
                Node previuos = Previuos(aux.getData());
                previuos.setLink(N);
            }
        }
    }
    
    public void Remove (int pos)
    {
        if(pos == 1)
            RemoveFirst();
        else
        {
             if(pos==size())
                 RemoveLast();
             else
             {
                 Node aux = first;
                 int counter=1;
                 while ( counter < pos)
                 {
                     counter++;
                     aux=aux.getLink();
                 }
                 Node previuos = Previuos(aux.getData());
                 previuos.setLink(aux.getLink());
                 aux=null;
             }
        }
    }

    
   

}
