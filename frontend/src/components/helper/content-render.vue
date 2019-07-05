<script>
  export default {
    name: "ContentRender",
    props: {
      content: {
        type: String,
        required: true,
      },
      methods: {
        type: Object,
        default: () => {},
      }
    },
    render(h) {
      return h({
        template: `
          <div>
            ${this.content}
          </div>  
        `,
        methods: this.methods,
      })
    },
  }
</script>